<#import "parts/common.ftl" as c>
<#import "parts/loginForm.ftl" as log>
<@c.page>
Login page
<@log.login "login" />
<a href="/registration">Add new user</a>
</@c.page>