package abyss.world.blocks.defense;

import arc.Core;
import mindustry.gen.*;
import mindustry.world.Block;
import abyss.world.blocks.affinity.*;

public class AffinityDamageBlock extends Block {
	public float basedamage = 69f;
	public float baseradius = 420f;
	public float affinityMultiplier = 2f;

	public AffinityDamageBlock(String name) {
		super(name);
		destructible = solid = update = configurable = true;
	}

	public class AffinityDamageBlockBuild extends Building {
		@Override
		public void updateTile() {
			for (int i = 0; i < this.proximity.size; i++) {
				if (this.proximity.get(i).block instanceof AffinityBlock.AffinityBlockBuild) {
					Core.app.exit();
				}
			}
		}
	}
}