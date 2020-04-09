<#import "/spring.ftl" as spring/>


<head>
<#include "../includable/bootstrap.ftl">
</head>


<body>

<#if page??>
<h1> ${page} </h1>
</#if>


<form action="create" method="POST">

<input type="text" name="firstname" placeholder="firstname">
<input type="text" name="lastname" placeholder="lastname">

<input type="submit" value="add"/>

</form>


</body>