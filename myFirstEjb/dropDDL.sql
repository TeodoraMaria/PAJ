ALTER TABLE User DROP FOREIGN KEY FK_User_organizationId
ALTER TABLE UserResource DROP FOREIGN KEY FK_UserResource_idresource
ALTER TABLE UserResource DROP FOREIGN KEY FK_UserResource_iduser
ALTER TABLE organization_resource DROP FOREIGN KEY FK_organization_resource_idorganization
ALTER TABLE organization_resource DROP FOREIGN KEY FK_organization_resource_idresource
DROP TABLE User
DROP TABLE Organization
DROP TABLE Resource
DROP TABLE UserResource
DROP TABLE organization_resource
