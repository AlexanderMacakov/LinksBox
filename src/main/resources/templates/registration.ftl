<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as log>

<@c.page>
Add new user
${message}
<@log.login "/registration" />
</@c.page>