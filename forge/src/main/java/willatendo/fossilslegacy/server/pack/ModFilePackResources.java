package willatendo.fossilslegacy.server.pack;

import net.minecraftforge.forgespi.locating.IModFile;
import net.minecraftforge.resource.PathPackResources;

import java.nio.file.Path;

public class ModFilePackResources extends PathPackResources {
    protected final IModFile modFile;
    protected final String sourcePath;

    public ModFilePackResources(String name, boolean builtIn, IModFile modFile, String sourcePath) {
        super(name, builtIn, modFile.findResource(sourcePath));
        this.modFile = modFile;
        this.sourcePath = sourcePath;
    }

    @Override
    protected Path resolve(String... paths) {
        String[] allPaths = new String[paths.length + 1];
        allPaths[0] = sourcePath;
        System.arraycopy(paths, 0, allPaths, 1, paths.length);
        return modFile.findResource(allPaths);
    }
}