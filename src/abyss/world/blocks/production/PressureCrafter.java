package abyss.world.blocks.production;

import arc.*;
import arc.math.*;
import arc.util.*;
import arc.util.io.*;
import arc.graphics.*;
import arc.graphics.g2d.*;
import mindustry.ui.*;
import mindustry.gen.*;
import mindustry.entities.*;
import mindustry.world.blocks.production.GenericCrafter;
import mindustry.world.consumers.*;

public class PressureCrafter extends GenericCrafter {
	public TextureRegion baseRegion, gasRegion, topRegion;
	public Color gasColor = Color.white;
	public float maxPressure = 90f, pressureBuildup = 0.07f, pressureThreshold = 75f;

	public PressureCrafter(String name) {
		super(name);
		updateEffect = new Effect(60f, e -> {
			Fill.circle(e.x, e.y, Interp.sine.apply(e.fin() * 2));
		});
	}

	@Override
	public void setBars() {
		super.setBars();
		bars.add("BAR", entity -> new Bar(
			"BAR",
			Color.white,
			() -> ((PressureCrafterBuild) entity).pressuref()
		));
	}

	@Override
	public void load() {
		super.load();
		baseRegion = Core.atlas.find(name + "-base");
		topRegion = Core.atlas.find(name + "-top");
		gasRegion = Core.atlas.find(name + "-gas");
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
				if(Mathf.chanceDelta(updateEffectChance)){
					updateEffect.at(getX() + Mathf.range(size * 4f), getY() + Mathf.range(size * 4));
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
			Draw.rect(baseRegion, x, y, 0f);
			Draw.color(gasColor);
			Draw.alpha(pressuref());
			Draw.rect(gasRegion, x, y, 0f);
			Draw.reset();
			Draw.alpha(1f);
			super.draw();
			Draw.rect(topRegion, x, y, 0f);
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