<#import "/spring.ftl" as spring/>


<head>
<#include "../includable/bootstrap.ftl">
</head>


<body>
<#include "../includable/header.ftl">

<#if page??>
<h1> ${page} </h1>
</#if>


Firstname : ${item.firstname}
<br>
Lastname : ${item.lastname}
<br>

<br>

This user has the following products : 
<br>
<#list item.products as product>
Product : <i> ${product.name} </i>
Price : <i> ${product.price} </i>

<br>
</#list>

</body>