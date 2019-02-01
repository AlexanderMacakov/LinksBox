<#macro registration path>
    <form action="${path}" method="post">
        <div><label>First Name: <input type="text" name="firstname"></label></div>
        <div><label>Last Name: <input type="text" name="lastname"></label></div>
        <div><label>Email: <input type="text" name="email"></label></div>
        <div><label>Password: <input type="password" name="password"></label></div>
        <div><input type="submit" value="Register"></div>
    </form>
</#macro>