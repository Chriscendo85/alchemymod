package com.symstudios.alchemymod.api;

import java.util.ArrayList;
import java.util.Random;

import com.symstudios.alchemymod.api.circle.AlchemyCircle;
import com.symstudios.alchemymod.api.effect.EffectBase;
import com.symstudios.alchemymod.api.recipe.RecipeInput;

public class AlchemyAPI {

	private static ArrayList<AlchemyCircle> circles = new ArrayList();
	private static ArrayList<EffectBase> effects = new ArrayList();
	private static ArrayList<EffectBase> effects2 = new ArrayList();
	private static ArrayList<QuestBase> quests = new ArrayList();

	public static void registerCircle(AlchemyCircle circle) {
		circles.add(circle);
	}
	
	public static void registerQuest(QuestBase quest) {
		quests.add(quest);
	}

	public static QuestBase getQuest(String name) {
		for (QuestBase b : quests)
		{
			if (b.getName().equals(name))
				return b;
		}
		return null;
	}
	
	public static AlchemyCircle findCircleFromRecipe(RecipeInput input) {
		for (AlchemyCircle circle : circles) {
			if (circle.matchesRecipe(input)) {
				return circle;
			}
		}
		return null;
	}

	public static AlchemyCircle findCircleFromName(String name) {
		for (AlchemyCircle circle : circles) {
			if (circle.getName().equalsIgnoreCase(name)) {
				return circle;
			}
		}
		return null;
	}

	public static void registerEffect(EffectBase effect) {
		effects.add(effect);
	}
	
	public static void registerEffect2(EffectBase effect) {
		effects2.add(effect);
	}

	public static EffectBase findEffectFromName(String name) {
		for (EffectBase effect : effects) {
			if (effect.getName().equalsIgnoreCase(name)) {
				return effect;
			}
		}
		return null;
	}

	public static EffectBase findRandomEffect() {
		Random random = new Random();
		return effects.get(random.nextInt(effects.size()));
	}
	
	public static EffectBase findRandomEffect2() {
		Random random = new Random();
		return effects2.get(random.nextInt(effects2.size()));
	}

}