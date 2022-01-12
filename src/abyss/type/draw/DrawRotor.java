package abyss.type.draw;

import arc.Core;
import arc.util.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.util.Time;
import mindustry.gen.Unit;

import mindustry.Vars;

public class DrawRotor {
	public final String name;
	public TextureRegion rotorRegion, jointRegion;

	public float x = 0f;
	public float y = 0f;
	public float s = 0f;

	public int blurAmount = 10;

	public DrawRotor(String name) {
		this.name = name;
	}

	public void load() {
		rotorRegion = Core.atlas.find(name);
		jointRegion = Core.atlas.find(name + "-joint");
	}

	public void draw(Unit unit) {
		float rx = unit.x + Angles.trnsx(unit.rotation - 90, x, y);
		float ry = unit.y + Angles.trnsy(unit.rotation - 90, x, y);

		for (int i = blurAmount; i > 0; i--) {
			float a = 1f/blurAmount * i;
			Draw.alpha(a);
			Draw.rect(rotorRegion, rx, ry, Time.time * 5f + unit.rotation - a);
		}
		Draw.alpha(1f);
		Draw.rect(jointRegion, rx, ry, 90f - unit.rotation);
	}
}