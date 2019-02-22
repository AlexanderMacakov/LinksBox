<#import "parts/common.ftl" as c>

<@c.page>
    Main page


    <div class="list-view">
        <#list catalogList as catalog>
            <ul>
                <a href="#">${catalog}</a>
            </ul>
        <#else>
            There are no folders!
        </#list>
    </div>


</@c.page>