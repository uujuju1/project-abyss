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

	public boolean drawJoint = true;

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

		Draw.rect(rotorRegion, rx, ry, Time.time * s + unit.rotation);
		if (drawJoint) {
			Draw.rect(jointRegion, rx, ry, unit.rotation - 90f);
		}
	}
}