package abyss.world.blocks.production;

import arc.*;
import arc.math.*;
import arc.util.io.*;
import arc.graphics.*;
import mindustry.ui.*;
import mindustry.gen.*;
import mindustry.world.blocks.production.GenericCrafter;
import mindustry.world.consumers.*;

public class PressureCrafter extends GenericCrafter {
	public TextureRegion[] gasRegions;
	public TextureRegion baseRegion, topRegion;
	public float gasSpinScl = 1f;
	public float maxPressure = 350f, pressureBuildup = 0.07f, pressureThreshold = 300f;

	public PressureCrafter(String name) {
		super(name);
	}

	@Override
	public void setBars() {
		super.setBars();
		bars.add("BAR", entity -> new Bar(
			"bar",
			Color.white,
			() -> ((PressureCrafterBuild) entity).pressuref()
		));
	}

	@Override
	public void load() {
		super.load();
		baseRegion = Core.atlas.find(name + "-base");
		topRegion = Core.atlas.find(name + "-top");
		gasRegions = new TextureRegion[4]{
			Core.atlas.find(name + "-gas-" + 0),
			Core.atlas.find(name + "-gas-" + 1),
			Core.atlas.find(name + "-gas-" + 2),
			Core.atlas.find(name + "-gas-" + 3)
		};
	}

	@Override
	public TextureRegion[] icons() {
		return new TextureRegion[]{baseRegion, region, topRegion};
	}

	public class PressureCrafterBuild extends GenericCrafter.GenericCrafterBuild {
		public float pressure = 0f;

		public float pressuref() {
			return pressure/maxPressure;
		}

		@Override
		public void updateTile() {
			if(cons.valid()) {
				pressure = Mathf.approachDelta(pressure, maxPressure, pressureBuildup);
				if (pressure >= pressureThreshold) {
					super.updateTile();
				}
			} else pressure = Mathf.approachDelta(pressure, 1f, pressureBuildup);

			if(outputItem != null && timer(timerDump, dumpTime / timeScale)){
				dump(outputItem.item);
			}

			if(outputLiquid != null){
				dumpLiquid(outputLiquid.liquid);
			}
		}

		@Override
		public void draw() {
			Draw.rect(baseRegion, x, y, 0);
			for (int i = 0; i < 4; i++) {
				Draw.rect(gasRegions[i], x, y, (Time.time * gasSpinScl) + (i * gasSpinScl));
			}
			super.draw();
		}

		@Override
		public void write(Writes write){
			write.f(pressure);
			super.write(write);
		}

		@Override
		public void read(Reads read, byte revision){
			pressure = read.f();
			super.read(read, revision);
		}
	}
}