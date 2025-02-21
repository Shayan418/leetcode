import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _1233RemoveSubFoldersfromtheFilesystem {
    public List<String> removeSubfolders(String[] folder) {
        List<String> result = new ArrayList<>();
        Arrays.sort(folder);

        int j = 0;
        for (int i = 0; i < folder.length && j < folder.length; ++i) {
            result.add(folder[i]);
            for (j = i + 1; j < folder.length; ++j) {
                if(!isSubFolder(folder[i], folder[j])) {
                    i = j-1;
                    break;
                }
            }
        }

        return result;
    }

    public boolean isSubFolder(String parent, String child) {
        if(child.length() < parent.length()) {
            return false;
        }
        for(int i = 0; i < parent.length(); ++i) {
            if(parent.charAt(i) != child.charAt(i)) {
                return false;
            }
        }
//        System.out.println(child.charAt(parent.length()));
        if(child.charAt(parent.length()) != '/') {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        _1233RemoveSubFoldersfromtheFilesystem obj = new _1233RemoveSubFoldersfromtheFilesystem();
        System.out.println(obj.removeSubfolders(new String[]{"/a","/a/b/c","/a/b/d"}));
        System.out.println(obj.removeSubfolders(new String[]{"/a/b/c","/a/b/ca","/a/b/d"}));

        System.out.println(obj.removeSubfolders(new String[]{"/a","/a/b","/c/d","/c/d/e","/c/f"}));

    }
}
