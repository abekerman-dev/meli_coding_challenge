package com.mercadolibre.codingchallenge.logic.chain;

/**
 * Patrón de diseño "Factory" que resuelve la creación de la instancia del chain
 * of responsibility
 * 
 * @author andres
 *
 */
public final class EvaluatorChainFactory {

	private static final PlanetsPositionEvaluator evaluator = init();

	private EvaluatorChainFactory() {
	}

	private static PlanetsPositionEvaluator init() {
		PlanetsPositionEvaluator planetsInTriangleWithSunInsideEvaluator = new PlanetsInTriangleWithSunInsideEvaluator(
				null);
		PlanetsPositionEvaluator planetsButNotSunAlignedEvaluator = new PlanetsButNotSunAlignedEvaluator(
				planetsInTriangleWithSunInsideEvaluator);

		return new PlanetsAndSunAlignedEvaluator(planetsButNotSunAlignedEvaluator);
	}

	public static PlanetsPositionEvaluator getChain() {
		return evaluator;
	}
}