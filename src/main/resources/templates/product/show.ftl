<#import "/spring.ftl" as spring/>


<head>
<#include "../includable/bootstrap.ftl">
</head>


<body>
<#include "../includable/header.ftl">

<#if page??>
<h1> ${page} </h1>
</#if>

Name : ${item.name}
<br>
Price : ${item.price}
<br>

</body>