package abyss.world.blocks.heat;

import arc.*;
import arc.util.*;
import mindustry.graphics.*;
import mindustry.gen.*;
import mindustry.ui.*;
import mindustry.world.meta.*;
import mindustry.world.Block;

public class HeatBlock extends Block {
	// min heat that the block can have
	public float minHeat = 25f;
	// max heat that the block can have
	public float maxHeat = 1000f;

	public HeatBlock(String name) {
		super(name);
		solid = destructible = sync = true;
		buildVisibility = BuildVisibility.shown;
	}

	public class HeatBlockBuild extends Building {
		public float heat = minHeat;

		public boolean acceptHeat(Building src, float amount) {
			return amount < maxHeat;
		}

		public void handleHeat(Building src, float amount) {
			if (acceptHeat(src, amount)) this.heat += amount;
		}

		public void updateHeat() {
			if (this.heat < minHeat) {
				this.heat -= Time.delta;
			}
		}

		@Override
		public void updateTile() {
			updateHeat();
			if (this.heat > maxHeat) {
				Core.app.exit();
			}
		}
	}
}