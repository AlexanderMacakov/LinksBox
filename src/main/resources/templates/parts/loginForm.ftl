<#macro login path>
    <form action="${path}" method="post">
        <div><label>Email: <input type="text" name="email"></label></div>
        <#if errorEmail??>
            <div>${errorEmail}</div>
        </#if>
        <div><label>Password: <input type="password" name="password"></label></div>
        <#if errorPassword??>
            <div>${errorPassword}</div>
        </#if>
        <div><input type="submit" value="Sign In"></div>
    </form>
</#macro>