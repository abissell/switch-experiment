enum ArraysHelper {
	@SuppressWarnings("UnusedDeclaration")INSTANCE; // Enum singleton

	public static <E> void fill(final E[] array, final ArrayFillFunction<? extends E> func) {
		for (int i = 0; i < array.length; ++i) {
			array[i] = func.getElementForIndex(i);
		}
	}

	public static void fillIntArray(final int[] array, final ArrayFillFunction<Integer> func) {
		for (int i = 0; i < array.length; ++i) {
			array[i] = func.getElementForIndex(i);
		}
	}

	public static void fillDoubleArray(final double[] array, final ArrayFillFunction<Double> func) {
		for (int i = 0; i < array.length; ++i) {
			array[i] = func.getElementForIndex(i);
		}
	}

	@SuppressWarnings("unchecked")
	public static <E> void forEach(final Object[] array, final ArrayFunctionOnElements<? super E> func) {
		for (Object obj : array) {
			func.f((E) obj);
		}
	}

	public static void forEach(final long[] array, final ArrayFunctionOnLongElements func) {
		for (long el : array) {
			func.f(el);
		}
	}

	public static void forEach(final long[] array, final ArrayFunctionOnLongIndexedElements func) {
		for (int i = 0; i < array.length; ++i) {
			func.f(i, array[i]);
		}
	}
}
