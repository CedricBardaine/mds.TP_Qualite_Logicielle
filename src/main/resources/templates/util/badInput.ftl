

<#import "/spring.ftl" as spring/>


<head>
<#include "../includable/bootstrap.ftl">
</head>


<body>
<#include "../includable/header.ftl">

Error... Bad input. <br>

<#if back??>
<a href="${back}">Get me back</a>
<#else>
<a href="/">Get me back to home</a> 
</#if>


</body>