package abyss.world.blocks.production;

import mindustry.gen.*;
import mindustry.world.blocks.production.GenericCrafter;

public class CrowdedCrafter extends GenericCrafter {
	public CrowdedCrafter(String name) {
		super(name);
	}

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

		@Override
		public boolean shouldConsume() {
			if (!this.getBuild()) {
				return false;
			}
			super.shouldConsume();
			return true;
		}
	}
}