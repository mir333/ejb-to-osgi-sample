Steps to deploy

* Download and unzip Liferay 7 WildFly bundle
* Add ``portal-ext.properties``with:
```
module.framework.system.packages.extra=\
	im.ligas.ejb.sample.remote,\
	im.ligas.ejb.sample.dto
```
* Compile all the projects
* Copy the ear into the `wildfly-10.0.0/standalone/deployments` folder
* Copy the portlet jar into Liferay deploy folder
* Copy the API jar into the global classloader `wildfly-10.0.0/modules/com/liferay/portal/main/`
* Add the jar reference into the `wildfly-10.0.0/modules/com/liferay/portal/main/module.xml`
```
<?xml version="1.0"?>

<module name="com.liferay.portal" xmlns="urn:jboss:module:1.0">
	<resources>
		<resource-root path="com.liferay.registry.api.jar" />
		<resource-root path="hsql.jar" />
		<resource-root path="mysql.jar" />
		<resource-root path="portal-kernel.jar" />
		<resource-root path="portlet.jar" />
		<resource-root path="postgresql.jar" />

		<resource-root path="ejb-sample-api-1.0-SNAPSHOT.jar" />

	</resources>
	<dependencies>
		<module name="ibm.jdk" />
		<module name="javax.api" />
		<module name="javax.mail.api" />
		<module name="javax.servlet.api" />
		<module name="javax.servlet.jsp.api" />
		<module name="javax.transaction.api" />
	</dependencies>
</module>

```
* Start the server
 
