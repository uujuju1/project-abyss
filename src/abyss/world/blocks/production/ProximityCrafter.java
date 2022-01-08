package abyss.world.blocks.production;

import arc.*;
import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.util.*;
import arc.struct.*;
import mindustry.gen.*;
import mindustry.world.meta.*;
import mindustry.world.blocks.defense.Wall.*;
import mindustry.world.consumers.*;
import mindustry.type.*;
import mindustry.world.meta.*;
import mindustry.world.Block;

public class ProximityCrafter extends Block {
	public float craftTime = 60f;
	public float warmupSpeed = 0.019f;

	public @Nullable ItemStack outputItem;

	public Color flameColor = Color.valueOf("ffc999"), flameColorIn = Color.valueOf("ffffff");
	public float flameRadius = 3f;

	public TextureRegion topRegion;

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

	@Override
	public void load() {
		super.load();
		topRegion = Core.atlas.find(name + "-top");
	}

	@Override
	public void setStats() {
		super.setStats();
		stats.add(Stat.productionTime, craftTime/60f, StatUnit.seconds);
		if (outputItem != null) {
			stats.add(Stat.output, StatValues.items(craftTime, outputItem));
		}
	}

	public class ProximityCrafterBuild extends Building {
		float reloadTime = 0f;
		float warmup = 0f;
		public float getProximityBlocks() {
			float mult = 0f;
			for (int i = 0; i < this.proximity.size; i++) {
				if (this.proximity.get(i) instanceof WallBuild) {
					mult += 0.1f;
				}
			}
			return mult;
		}

		@Override
		public boolean shouldConsume(){
			if(outputItem != null && items.get(outputItem.item) + outputItem.amount > itemCapacity){
				return false;
			}
			if (this.getProximityBlocks() == 0f) {
				return false;
			}
			return true;
		}

		@Override
		public void updateTile() {
			if (cons.valid()) {
				warmup = Mathf.approachDelta(warmup, 1f, warmupSpeed);
				reloadTime += (Time.delta*this.getProximityBlocks());
				if (reloadTime >= craftTime && shouldConsume()) {
					consume();
					if (outputItem != null) {
						for (int i = 0; i < outputItem.amount; i++) {
							offload(outputItem.item);
						}
					}
					reloadTime = 0f;
				}
			} else {
				warmup = Mathf.approachDelta(warmup, 0f, warmupSpeed);
			}
			if (outputItem != null) {
				dump(outputItem.item);
			}
		}

		@Override
		public void draw() {
			Draw.alpha(warmup);
			Draw.rect(topRegion, x, y, 0);
			Draw.color(flameColor);
			Fill.circle(x, y, flameRadius);
			Draw.color(flameColorIn);
			Fill.circle(x, y, flameRadius/2);
			Draw.color();
		}
	}
}