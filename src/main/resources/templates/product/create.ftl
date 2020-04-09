<#import "/spring.ftl" as spring/>


<head>
<#include "../includable/bootstrap.ftl">
</head>


<body>
<#include "../includable/header.ftl">

<#if page??>
<h1> ${page} </h1>
</#if>


<form action="create" method="POST">

<input type="text" name="name" placeholder="name">
<input type="text" name="price" placeholder="price">

<input type="submit" value="add"/>

</form>


</body>