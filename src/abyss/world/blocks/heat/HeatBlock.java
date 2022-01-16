package abyss.world.blocks.heat;

import arc.*;
import arc.util.*;
import arc.graphics.g2d.*;
import mindustry.graphics.*;
import mindustry.gen.*;
import mindustry.world.meta.*;
import mindustry.world.Block;

public class HeatBlock extends Block {
	public TextureRegion top;
	// min heat that the block can have
	public float minHeat = 25f;
	// max heat that the block can have
	public float maxHeat = 1000f;

	public HeatBlock(String name) {
		super(name);
		solid = destructible = sync = true;
		buildVisibility = BuildVisibility.shown;
	}

	@Override
	public void load() {
		super.load();
		top = Core.atlas.find(name + "-top");
	}

	public class HeatBlockBuild extends Building {
		public float heat = minHeat;

		public boolean acceptHeat(Building src, float amount) {
			return amount < maxHeat;
		}

		public void handleHeat(Building src, float amount) {
			if (acceptHeat(src, amount)) this.heat += amount;
		}

		public float getHeat() {
			return this.heat;
		}

		public void updateHeat() {
			if (this.heat > minHeat) {
				this.heat -= Time.delta;
			}
			if (this.heat > maxHeat) {
				kill();
			}
		}

		@Override
		public void updateTile() {
			updateHeat();
		}

		@Override
		public void draw() {
			super.draw();
			float alpha = this.heat/maxHeat;
			Draw.alpha(alpha);
			Draw.rect(top, x, y, 0);
		}
	}
}