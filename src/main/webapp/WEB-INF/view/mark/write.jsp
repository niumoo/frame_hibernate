<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, shrink-to-fit=no, initial-scale=1">
<title>编写新的文章</title>
<link rel="stylesheet"  href="${pageContext.request.contextPath}/css/simple-sidebar.css">
<link rel="stylesheet"	href="${pageContext.request.contextPath}/mark/css/style.css" />
<link rel="stylesheet"	href="${pageContext.request.contextPath}/mark/css/editormd.css" />
<link rel="stylesheet"  href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/mark/js/editormd.js"></script>
</head>

<script type="text/javascript">
	function save() {
		var status = $("#status option:selected").val();
		var title = $("#title").val();
		var subhead = $("#subhead").val();
		var summary = $("#summary").val();
		var path = $("#path").val();
		var markdown = testEditor.getMarkdown();
		var htmlContent = testEditor.getHTML();
		var tags = $("#tags").val();
		$.ajax({
			url : "${pageContext.request.contextPath}/mark/save", //请求的url地址
			dataType : "json", //返回格式为json
			async : true, //请求是否异步，默认为异步，这也是ajax重要特性
			data : {
				"status":status,
				"title" : title,
				"subhead" : subhead,
				"summary" : summary,
				"path" : path,
				"markdown" : markdown,
				"htmlContent" : htmlContent,
				"tags" :tags
			}, //参数值
			type : "POST", //请求方式
			 success:function(code){
	               if(code==1){
	                   alert("文章已更新发布");
	               }
	               if(code==0){
	                   alert("信息填写不完整");
	               }
	               if(code == 2){
	                   alert("文章路径已经存在");
	               } 
	               if(code == 3){
                       alert("保存失败");
                   }
	            },
			error : function() {
				alert("出错");
			}
		});
	}
</script>

<body style="background-color: #4E4E4E">
   <div id="layout">
    <div id="test-editormd">
     <textarea style="display: none;">[TOC]
		
### Themes

#### Setting

configs:

```javascript
{
    // Editor.md theme, default or dark, change at v1.5.0
    // You can also custom css class .editormd-theme-xxxx
    theme : "default | dark",

    // Preview container theme, added v1.5.0
    // You can also custom css class .editormd-preview-theme-xxxx
    previewTheme : "default | dark",

    // Added @v1.5.0 & after version this is CodeMirror (editor area) theme
    editorTheme : editormd.editorThemes['theme-name']
}
```

functions:

```javascript
editor.setTheme('theme-name');
editor.setEditorTheme('theme-name');
editor.setPreviewTheme('theme-name');
```

#### Default theme

- Editor.md theme : `default`
- Preview area theme : `default`
- Editor area theme : `default`

> Recommend `dark` theme.

#### Recommend editor area themes

- ambiance
- eclipse
- mdn-like
- mbo
- monokai
- neat
- pastel-on-dark

#### Editor area themes

- default
- 3024-day
- 3024-night
- ambiance
- ambiance-mobile
- base16-dark
- base16-light
- blackboard
- cobalt
- eclipse
- elegant
- erlang-dark
- lesser-dark
- mbo
- mdn-like
- midnight
- monokai
- neat
- neo
- night
- paraiso-dark
- paraiso-light
- pastel-on-dark
- rubyblue
- solarized
- the-matrix
- tomorrow-night-eighties
- twilight
- vibrant-ink
- xq-dark
- xq-light
	</textarea>
    
    </div>
   </div>
   
<div class="container" style="background-color: white;padding-top: 20px;border-radius: 10px;">
    <div class="row">
        <div class="col-lg-12  col-md-12 text-left">
	                        标题：
	        <input style="width: 100%;" type="text" id="title"   class="form-control">
	                         副标题：
	        <input type="text" style="width: 100%;" id="subhead" class="form-control" >
	                          摘要：
	        <input style="width: 100%;" type="text" id="summary" class="form-control" >
	                            路径：
	        <input style="width: 100%;" type="text" id="path" class="form-control" placeholder="不要以/开头" >
	                          标签：<br/>
	        <input type="text" class="form-control" id="tags" placeholder="多个标签用英文,隔开">
	                          状态：
	         <select class="form-control" style="width:150px" id="status">
	                      <option value="1">公开展示</option>
	                  <option value="0">不公开</option>
	         </select>
	        <br/>
	        <button value="发布" onclick="save()" class="btn btn-primary">保存</button>
	        
	        <br/><br/>
	        <table class="table table-striped">
	        <c:forEach items="${postList}" var="post">
	            <tr><td>${post.title}</td><td>
                <fmt:formatDate value="${post.createTime}" pattern="yyyy-MM-dd"/>
                </td><td><a href="${pageContext.request.contextPath}/mark/index?id=${post.id}">编辑</a> 
                                                                                                    状态：${post.status == 0? '未发布' : '已发布'}</td></tr>
	        </c:forEach>
			</table>
        </div>
    </div>
<div>
   <br/> <br/> <br/> <br/> <br/>
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</body>
</html>
<script type="text/javascript">
        var testEditor;

        function themeSelect(id, themes, lsKey, callback) {
            var select = $("#" + id);

            for (var i = 0, len = themes.length; i < len; i++) {
                var theme = themes[i];
                var selected = (localStorage[lsKey] == theme) ? " selected=\"selected\""
                        : "";

                select
                        .append("<option value=\"" + theme + "\"" + selected + ">"
                                + theme + "</option>");
            }

            select.bind("change", function() {
                var theme = $(this).val();

                if (theme === "") {
                    alert("theme == \"\"");
                    return false;
                }

                console.log("lsKey =>", lsKey, theme);

                localStorage[lsKey] = theme;
                callback(select, theme);
            });

            return select;
        }

        $(function() {
            testEditor = editormd(
                    "test-editormd",
                    {
                        width : "100%",
                        height : 720,
                        saveHTMLToTextarea : true,
                        tocm : true,
                        taskList : true,
                        imageUpload : true,
                        imageFormats : [ "jpg", "jpeg", "gif", "png", "bmp",
                                "webp" ],
                        imageUploadURL : "${pageContext.request.contextPath}/mark/upload",
                        // Editor.md theme, default or dark, change at v1.5.0
                        // You can also custom css class .editormd-preview-theme-xxxx
                        theme : (localStorage.theme) ? localStorage.theme
                                : "dark",
                        // Preview container theme, added v1.5.0
                        // You can also custom css class .editormd-preview-theme-xxxx
                        previewTheme : (localStorage.previewTheme) ? localStorage.previewTheme
                                : "dark",
                        // Added @v1.5.0 & after version is CodeMirror (editor area) theme
                        editorTheme : (localStorage.editorTheme) ? localStorage.editorTheme
                                : "pastel-on-dark",
                        path : '${pageContext.request.contextPath}/mark/lib/',
                        toolbarIconTexts : {
                            save : "save"  // 如果没有图标，则可以这样直接插入内容，可以是字符串或HTML标签
                        }
                    });
            
            themeSelect("editormd-theme-select", editormd.themes, "theme",
                    function($this, theme) {
                        testEditor.setTheme(theme);
                    });

            themeSelect("editor-area-theme-select", editormd.editorThemes,
                    "editorTheme", function($this, theme) {
                        testEditor.setCodeMirrorTheme(theme);
                        // or testEditor.setEditorTheme(theme);
                    });

            themeSelect("preview-area-theme-select", editormd.previewThemes,
                    "previewTheme", function($this, theme) {
                        testEditor.setPreviewTheme(theme);
                    });
            $("#toc-menu-btn").click(function() {
                testEditor.config({
                    tocDropdown : true,
                    tocTitle : "目录 Table of Contents",
                });
            });

        });
    </script>
