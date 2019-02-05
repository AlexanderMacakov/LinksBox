<#import "parts/common.ftl" as c>
<#import "parts/loginForm.ftl" as log>
<@c.page>
Login page

    <#if message??>
        <div><h3>${message}</h3></div>
    </#if>
<@log.login "login" />
<a href="/registration">Add new user</a>
</@c.page>