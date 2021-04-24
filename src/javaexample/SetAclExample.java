import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.AclEntry;
import java.nio.file.attribute.AclEntryPermission;
import java.nio.file.attribute.AclEntryType;
import java.nio.file.attribute.AclFileAttributeView;
import java.nio.file.attribute.UserPrincipal;
import java.util.List;

public class SetAclExample {

	public static void main(String[] args) {

		String file = "/Users/aanverma/Desktop/labs/java/setfacl_java.txt";// initial perm: 644, aanverma:staff
		Path path = Paths.get(file);

		UserPrincipal userPrincipal = null;
		try {
			userPrincipal = FileSystems.getDefault().getUserPrincipalLookupService().lookupPrincipalByName("aanverma");
			AclEntry aclEntry = AclEntry.newBuilder().setPermissions(AclEntryPermission.EXECUTE)
					.setType(AclEntryType.ALLOW).setPrincipal(userPrincipal).build();

			AclFileAttributeView acl = Files.getFileAttributeView(path, AclFileAttributeView.class,
					LinkOption.NOFOLLOW_LINKS);
			List<AclEntry> aclEntries;
			aclEntries = acl.getAcl();

			aclEntries.add(aclEntry);

			acl.setAcl(aclEntries);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
