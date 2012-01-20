<#setting number_format="#">
<head>
   <title>写新日志</title>
</head>
<body>
    <form name="writearticle" method="post" action="saveArticle">
      <table>
       <tr>
       <#--
         <th><input type="hidden" name="artId"     value="${article.artId?if_exists}"/></th>
       -->  
         <th><input type="hidden" name="artTime"   value="${(article.artTime?if_exists)?string}"></th>
         <th><input type="hidden" name="artAuthor" value="${article.artAuthor?if_exists}"></th>
          <th><input type="hidden" name="artCatagory" value="${article.artCatagory?if_exists}"></th>
         
       </tr>
       <tr>
          <th>主题</th>
          <th><input type="text" name="artSubject" value="${article.artSubject?if_exists}" size="116px*50px" align="left"/></th>
       </tr>
       <tr>
         <th>内容</th>
         <th><textarea rows="25" cols="100" name="artContent" value="${article.artContent?if_exists}" align="left"></textarea>
         </th>
       </tr>
       <#--
	       <tr align="left">
	         <th >类别</th>
	         <th align="left">
	            <select name="artCatagory">
				  <#if catagoriesList??&&(catagoriesList?size>0)>
	                <#list catagoriesList as catagories>
	                  <option value ="${catagories.cataName?if_exists}">${catagories.cataName?if_exists}</option>
	                </#list>
	  			 </#if> 
				</select>
	         </th>
	        </tr>
	   -->     
        <tr>
          <th>&nbsp;</th>
          <th><input type="submit" value="发表"></th>
        </tr>       
       </table>
     </form>
</body>