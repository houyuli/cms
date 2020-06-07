<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String htmlData = request.getParameter("content1") != null ? request.getParameter("content1") : "";
%>
<!doctype html>
<html>
<head>
<meta charset="utf-8" />
<title>KindEditor JSP</title>
<link rel="stylesheet"
	href="/resource/kindeditor/themes/default/default.css" />
<link rel="stylesheet"
	href="/resource/kindeditor/plugins/code/prettify.css" />
<script charset="utf-8" src="/resource/kindeditor/kindeditor.js"></script>
<script charset="utf-8" src="/resource/kindeditor/lang/zh-CN.js"></script>
<script charset="utf-8"
	src="/resource/kindeditor/plugins/code/prettify.js"></script>
<script>
	KindEditor.ready(function(K) {
		window.editor1 = K.create('textarea[name="content1"]', {
			cssPath : '/resource/kindeditor/plugins/code/prettify.css',
			uploadJson : '/resource/kindeditor/jsp/upload_json.jsp',
			fileManagerJson : '/resource/kindeditor/jsp/file_manager_json.jsp',
			allowFileManager : true,
			afterCreate : function() {
				var self = this;
				K.ctrl(document, 13, function() {
					self.sync();
					document.forms['example'].submit();
				});
				K.ctrl(self.edit.doc, 13, function() {
					self.sync();
					document.forms['example'].submit();
				});
			}
		});
		prettyPrint();
	});
</script>
</head>
<body>
	<form id="form1">
		<div class="form-group">
			<label for="title"> 文章标题：</label> <input id="title"
				class="form-control" type="text" name="title">
		</div>
		<div class="form-group">
			<label for="file">标题图片：</label> <input id="file" type="file"
				name="file" class="form-control-file">
		</div>
		<div class="form-group form-inline">
			所属栏目： <select class="form-control" id="channel" name="channelId">
				<option>请选择</option>
			</select> 所属分类： <select class="form-control" id="category" name="categoryId">
				<option></option>
			</select>
		</div>
		<div>
			<textarea name="content1" cols="100" rows="8"
				style="width: 1102.16px; height: 200px; visibility: hidden;"><%=htmlspecialchars(htmlData)%></textarea>
			<br />
		</div>
		<input type="button" name="button" class="btn btn-primary" value="发布"
			onclick="publish()" />
	</form>
</body>
<script type="text/javascript">
	//发布
	function publish() {
		var formData = new FormData($("#form1")[0]);
		formData.set("content", editor1.html());//封装富文本编辑器中输入的带样式的内容
		$.ajax({
			type:"post",
			data : formData,
			url : "/my/publish",
			processData : false,//jquery不要处理发送东西
			contentType : false,//jquery 不要出处理发送的类型
			success : function(flag) {
				alert(formData);
				if (flag) {
					alert("发布成功");
					location.href = "/my" //跳转到我的文章页面
				} else {
					alert("发布失败");
				}
			}
		})
	}
	$(function() {
		//自动填充栏目
		$.get("/my/channels", function(list) {
			for ( var i in list) {
				$("#channel").append(
						"<option value='"+list[i].id+"'>" + list[i].name
								+ "</option>")
			}
		//为栏目添加内容改变事件
		$("#channel").change(
				function() {
					//获取当前选中的值
					var channelId = $(this).val();
					//先清空原有分类值
					$("#category").empty();
					$.get("/my/categorys", {
						channelId : channelId
					}, function(list) {
						for ( var i in list) {
							$("#category").append(
									"<option value='"+list[i].id+"'>"
											+ list[i].name + "</option>")
						}
					})
				})
		})
	})
</script>

</html>
<%!private String htmlspecialchars(String str) {
		str = str.replaceAll("&", "&amp;");
		str = str.replaceAll("<", "&lt;");
		str = str.replaceAll(">", "&gt;");
		str = str.replaceAll("\"", "&quot;");
		return str;
	}%>