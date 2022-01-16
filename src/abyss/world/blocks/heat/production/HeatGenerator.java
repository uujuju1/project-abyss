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
		hasItems = true;
		itemCapacity = 5;
	}

	public class HeatGeneratorBuild extends HeatBlock.HeatBlockBuild {
		float reload = 0f;
		@Override
		public void updateTile() {
			updateHeat();
			if (cons.valid() && shouldConsume()) {
				if (this.reload >= produceTime) {
					consume();
					handleHeat(this, heatAmount);
					this.reload = 0f;
				}
				this.reload += Time.delta;
			}
		}

		@Override
		public boolean shouldConsume() {
			if(heatAmount != 0 && this.heat + heatAmount > maxHeat){
				return false;
			}
			return true;
		}
	}
}