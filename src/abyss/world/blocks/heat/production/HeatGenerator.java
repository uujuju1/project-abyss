package abyss.world.blocks.heat.production;

import arc.util.*;
import mindustry.gen.*;
import mindustry.world.consumers.*;
import abyss.world.blocks.heat.HeatBlock;

public class HeatGenerator extends HeatBlock {
	public float heatAmount = 69f;
	public float produceTime = 60f;

	public HeatGenerator(String name) {
		super(name);
	}

	public class HeatGeneratorBuild extends HeatBlock.HeatBlockBuild {
		float reload = 0f;
		@Override
		public void updateTile() {
			super.updateTile();
			if (cons.valid()) {
				if (this.heat >= produceTime) {
					handleHeat(this, heatAmount);
					this.reload = 0f;
				} else {
					this.reload += Time.delta;
				}
			}
		}
	}
}