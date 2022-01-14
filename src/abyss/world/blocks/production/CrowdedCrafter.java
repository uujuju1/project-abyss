package abyss.world.blocks.production;

import mindustry.gen.*;
import mindustry.world.blocks.production.GenericCrafter.*;

public class CrowdedCrafter extends GenericCrafter {
	public CrowdedCrafter(String name) {}

	public class CrowdedCrafterBuild extends GenericCrafterBuild {
		public boolean getBuild() {
			boolean hasBuild = false;
			for (int i = 0; i < this.proximity.size; i++) {
				if (this.proximity.get(i) instanceof CrowdedCrafterBuild) {
					hasBuild = true;
				}
			}
			return hasBuild;
		}
		public boolean shouldConsume() {
			if(outputItem != null && items.get(outputItem.item) + outputItem.amount > itemCapacity){
				return false;
			}
			if (!this.getBuild()) {
				return false;
			}
			return true;
		}
	}
}