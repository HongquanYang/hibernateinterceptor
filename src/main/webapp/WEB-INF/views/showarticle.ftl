<#setting number_format="#">
<head>
   <title>浏览日志</title>
</head>
<body>
    <form name="showarticle">
      <table>
       <tr>
         <th><input type="hidden" name="artId"     value="${article.artId?if_exists}"/></th>
       </tr>
       <tr>
          <th>主题</th>
          <th><input type="text" name="artSubject" value="${article.artSubject?if_exists}" size="116px*50px" align="left" border="0" readOnly="true"/></th>
       </tr>
       <tr>
         <th>内容</th>
         <th><textarea rows="25" cols="100" name="artContent" readOnly="true" align="left" border="0">${article.artContent?if_exists}</textarea>
         </th>
       </tr>
     
       <tr>
          <#--
	       <th><a href="viewPreBlog?id=${article.artId?if_exists}">上一篇日志</a></th>
	       <th><a href="viewNextBlog?id=${article.artId?if_exists}">下一篇日志</a></th>
	      --> 
	       <th><a href="showAllArticles">返回日志列表</a></th>
       </tr>
      
      </table>
     </form>
</body>