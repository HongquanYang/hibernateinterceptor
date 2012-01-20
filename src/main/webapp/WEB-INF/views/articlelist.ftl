<#setting number_format="#">
<title>日志中心</title>
<body>
   <div align="center"><a href="wirteArticle">写新日志</a></div>
   <div align="left"><hr>日志列表</hr></div>
   <table>
       <#if articleList??&&(articleList?size>0)>
            <#list articleList as article>
             <tr>
              <td><a href="showArticle?id=${article.artId?if_exists}"> ${article.artSubject?if_exists}</a></td>
              <td>${article.artTime?if_exists}</td>
              <td><a href="editArticle?id=${article.artId?if_exists}"> 编辑</a></td>
              <td><a href="delArticle?id=${article.artId?if_exists}"> 删除</a></td>
             </tr> 
            </#list>
  	   </#if> 
   </table>
</body>

