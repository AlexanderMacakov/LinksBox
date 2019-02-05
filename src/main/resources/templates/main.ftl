<#import "parts/common.ftl" as c>

<@c.page>
Main page
    <#if message??>
        <div><h3>${message}</h3></div>
    </#if>
</@c.page>