<#---->
<#macro script name>
<script src="<@rootPath/>/${name}" type="text/javascript"></script>
</#macro>

<#macro style name>
<link href="<@rootPath/>/${name}" type="text/css" media="screen" rel="stylesheet"/>
</#macro>
<#-- root path -->
<#macro rootPath>${springMacroRequestContext.getContextPath()}</#macro>