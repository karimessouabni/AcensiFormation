import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import junit.framework.Assert;
import junit.framework.TestCase;

public class LinearInterpolationTest extends TestCase {

	@Mock
	RateCurve rateMock ;

	@Test
	public void testLinearInterpolation() throws Exception {
		
		rateMock = Mockito.mock(RateCurve.class);
		Mockito.when(rateMock.getValueof(Mockito.any(Integer.class))).thenReturn(null);
		Mockito.when(rateMock.getValueof((Integer)25)).thenReturn(0.0680790380);
		Mockito.when(rateMock.getValueof((Integer)50)).thenReturn(0.0686192760);
		Mockito.when(rateMock.getValueof((Integer)75)).thenReturn(0.0694458250);
		
		Mockito.when(rateMock.getMaxHeaderValue()).thenReturn(75);


		LinearInterpolation interpolation = new LinearInterpolation(rateMock);

		Assert.assertEquals(0.06808119895199999, interpolation.linearInterpolation(25.1d));
		Assert.assertEquals(0.05990955344, interpolation.linearInterpolation(22d));
		Assert.assertEquals(0.0, interpolation.linearInterpolation(0d));
		Assert.assertEquals(0.0694458250, interpolation.linearInterpolation( 75d));

	}
}
