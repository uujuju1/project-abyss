package abyss.type.draw;

import arc.Core;
import arc.util.*;
import mindustry.graphics.*;
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

	public int bladeCount = 4;

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

		for (int i = 0; i < bladeCount; i++) {
			float r = 360/bladeCount * i;
			Draw.rect(rotorRegion, rx, ry, Time.time * s + unit.rotation + r);
		}

		if (drawJoint) {
			Draw.rect(jointRegion, rx, ry, unit.rotation - 90f);
		}
	}

	public void drawShadow(Unit unit) {
		float sx = unit.x + Angles.trnsx(unit.rotation - 90, x, y);
		float sy = unit.y + Angles.trnsy(unit.rotation - 90, x, y);
		float e = Math.max(unit.elevation, visualElevation);
		// essentially remake the rotor draw code for the shadow
		Draw.color(Pal.shadow);
		for (int i = 0; i < bladeCount; i++) {
			float r = 360/bladeCount * i;
			Draw.rect(rotorRegion, rx + shadowTX * e, ry + shadowTY * e, Time.time * s + unit.rotation + r);
		}
		Draw.color();
	}
}