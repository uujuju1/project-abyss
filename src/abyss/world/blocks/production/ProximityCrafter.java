package abyss.world.blocks.production;

import arc.util.*;
import arc.struct.*;
import mindustry.gen.*;
import mindustry.world.meta.*;
import mindustry.world.blocks.defense.Wall.*;
import mindustry.world.consumers.*;
import mindustry.type.*;
import mindustry.world.Block;

public class ProximityCrafter extends Block {
	public float craftTime = 60f;
	public @Nullable ItemStack outputItem;

	public ProximityCrafter(String name) {
		super(name);
		update = true;
		solid = true;
		hasItems = true;
		ambientSound = Sounds.machine;
		sync = true;
		ambientSoundVolume = 0.03f;
		flags = EnumSet.of(BlockFlag.factory);
	}

	public class ProximityCrafterBuild extends Building {
		float reload;
		float reloadTime;
		public float getProximityBlocks() {
			float mult = 0f;
			for (int i = 0; i < this.proximity.size; i++) {
				if (this.proximity.get(i) instanceof WallBuild) {
					mult += 0.2f;
				}
			}
			return mult;
		}

		@Override
		public void updateTile() {
			reload = craftTime*this.getProximityBlocks();
			if (cons.valid()) {
				reloadTime += Time.delta;
				if (reloadTime >= reload) {
					if (outputItem != null) {
						for (int i = 0; i < outputItem.amount; i++) {
							offload(outputItem.item);
						}
					}
					reloadTime = 0f;
				}
			}
		}
	}
}