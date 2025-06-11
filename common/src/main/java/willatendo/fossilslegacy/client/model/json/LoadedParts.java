package willatendo.fossilslegacy.client.model.json;

import com.google.common.collect.Maps;
import net.minecraft.client.model.geom.ModelPart;

import java.util.List;
import java.util.Map;

public class LoadedParts {
    private final Map<String, Integer> identifiers = Maps.newHashMap();
    private final ModelPart[] modelParts;

    public LoadedParts(List<String> names, ModelPart root) {
        this.modelParts = new ModelPart[names.size() + 1];
        int i = 0;
        for (String name : names) {
            for (ModelPart modelPart : root.getAllParts().toList()) {
                if (modelPart.hasChild(name)) {
                    this.modelParts[i] = modelPart.getChild(name);
                    this.identifiers.put(name, i);
                    i++;
                    break;
                }
            }
        }
        this.modelParts[i] = root;
        this.identifiers.put("root", i);
    }

    public ModelPart get(String name) {
        return this.modelParts[this.identifiers.get(name)];
    }

    public float getX(String name) {
        return this.modelParts[this.identifiers.get(name)].x;
    }

    public float getY(String name) {
        return this.modelParts[this.identifiers.get(name)].y;
    }

    public float getZ(String name) {
        return this.modelParts[this.identifiers.get(name)].z;
    }

    public void setX(String name, float angle) {
        this.modelParts[this.identifiers.get(name)].x = angle;
    }

    public void setY(String name, float angle) {
        this.modelParts[this.identifiers.get(name)].y = angle;
    }

    public void setZ(String name, float angle) {
        this.modelParts[this.identifiers.get(name)].z = angle;
    }

    public void addX(String name, float angle) {
        this.modelParts[this.identifiers.get(name)].x += angle;
    }

    public void addY(String name, float angle) {
        this.modelParts[this.identifiers.get(name)].y += angle;
    }

    public void addZ(String name, float angle) {
        this.modelParts[this.identifiers.get(name)].z += angle;
    }

    public void subtractX(String name, float angle) {
        this.modelParts[this.identifiers.get(name)].x -= angle;
    }

    public void subtractY(String name, float angle) {
        this.modelParts[this.identifiers.get(name)].y -= angle;
    }

    public void subtractZ(String name, float angle) {
        this.modelParts[this.identifiers.get(name)].z -= angle;
    }

    public float getXRot(String name) {
        return this.modelParts[this.identifiers.get(name)].xRot;
    }

    public float getYRot(String name) {
        return this.modelParts[this.identifiers.get(name)].yRot;
    }

    public float getZRot(String name) {
        return this.modelParts[this.identifiers.get(name)].zRot;
    }

    public void setXRot(String name, float angle) {
        this.modelParts[this.identifiers.get(name)].xRot = angle;
    }

    public void setYRot(String name, float angle) {
        this.modelParts[this.identifiers.get(name)].yRot = angle;
    }

    public void setZRot(String name, float angle) {
        this.modelParts[this.identifiers.get(name)].zRot = angle;
    }

    public void addXRot(String name, float angle) {
        this.modelParts[this.identifiers.get(name)].xRot += angle;
    }

    public void addYRot(String name, float angle) {
        this.modelParts[this.identifiers.get(name)].yRot += angle;
    }

    public void addZRot(String name, float angle) {
        this.modelParts[this.identifiers.get(name)].zRot += angle;
    }

    public void subtractXRot(String name, float angle) {
        this.modelParts[this.identifiers.get(name)].xRot -= angle;
    }

    public void subtractYRot(String name, float angle) {
        this.modelParts[this.identifiers.get(name)].yRot -= angle;
    }

    public void subtractZRot(String name, float angle) {
        this.modelParts[this.identifiers.get(name)].zRot -= angle;
    }

    public void setPos(String name, float x, float y, float z) {
        this.modelParts[this.identifiers.get(name)].setPos(x, y, z);
    }
}
