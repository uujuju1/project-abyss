package abyss.world.blocks.production;

import arc.*;
import arc.math.*;
import arc.util.io.*;
import mindustry.ui.*;
import mindustry.world.blocks.production.GenericCrafter;

public class PressureCrafter extends GenericCrafter {
	public float maxPressure = 350f, pressureBuildup = 0.001f, pressureThreshold = 300f;

	public PressureCrafter(String name) {
		super(name);
	}

	@Override
	public void setBars() {
		super.setBars();
		bars.add("BAR", entity -> new Bar(
			Core.bundle.get("bar.pressure") + ((PressureCrafterBuild) entity).pressure(),
			Color.white,
			() -> ((PressureCrafterBuild) entity).pressuref()
		));
	}

	public class PressureCrafterBuild extends GenericCrafter.GenericCrafterBuild {
		public float pressure = 0f;

		public float pressuref() {
			return pressure/maxPressure;
		}
		public float pressure() {
			return pressure;
		}

		@Override
		public void updateTile() {
			if(consValid()){
				pressure = Mathf.approachDelta(pressure, maxPressure, pressureBuildup);

				if(Mathf.chanceDelta(updateEffectChance)){
					updateEffect.at(getX() + Mathf.range(size * 4f), getY() + Mathf.range(size * 4));
				}

				if (pressure >= pressureThreshold) {
					progress += getProgressIncrease(craftTime);
					totalProgress += delta();
					warmup = Mathf.approachDelta(warmup, 1f, warmupSpeed);
				}
			}else{
				pressure = Mathf.approachDelta(pressure, 0f, pressureBuildup);
				warmup = Mathf.approachDelta(warmup, 0f, warmupSpeed);
			}

			if(progress >= 1f){
				consume();

				if(outputItem != null){
					for(int i = 0; i < outputItem.amount; i++){
						offload(outputItem.item);
					}
				}

				if(outputLiquid != null){
					handleLiquid(this, outputLiquid.liquid, outputLiquid.amount);
				}

				craftEffect.at(x, y);
				progress %= 1f;
			}

			if(outputItem != null && timer(timerDump, dumpTime / timeScale)){
				dump(outputItem.item);
			}

			if(outputLiquid != null){
				dumpLiquid(outputLiquid.liquid);
			}
		}

		@Override
		public void write(Writes write){
			super.write(write);
			write.f(pressure);
		}

		@Override
		public void read(Reads read, byte revision){
			super.read(read, revision);
			pressure = read.f();
			if(legacyReadWarmup) read.f();
		}
	}
}