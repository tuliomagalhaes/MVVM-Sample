package com.tuliohdev.mvvmsample.ui.main.converter;

import android.graphics.drawable.Drawable;
import com.tuliohdev.mvvmsample.R;
import com.tuliohdev.mvvmsample.data.model.presentationmodel.CreditCardPM;
import com.tuliohdev.mvvmsample.data.model.repositorymodel.CreditCardRM;
import com.tuliohdev.mvvmsample.testutils.CreditCardRMGenerator;
import com.tuliohdev.mvvmsample.utils.ResourcesManager;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Created by tulio on 26/01/18.
 */
@RunWith(MockitoJUnitRunner.class)
public class CreditCardConverterTest {

    @Mock
    private ResourcesManager mResourcesManager;
    @Mock
    private Drawable mDrawable;

    private CreditCardConverter mCreditCardConverter;

    @Before
    public void setUp() throws Exception {
        mCreditCardConverter = new CreditCardConverter(mResourcesManager);

        when(mResourcesManager.getDrawable(anyInt())).thenReturn(mDrawable);
    }

    @Test
    public void testIfApplyWouldReturnCorrectValuesAndMastercardBrand()  {
        // Given
        List<CreditCardRM> creditCardRMList = CreditCardRMGenerator.generateListBasedOnBrandType(CreditCardRM.BrandType.MASTERCARD);

        // When
        List<CreditCardPM> creditCardPMList = mCreditCardConverter.apply(creditCardRMList);

        // Then
        assertThat(creditCardPMList).hasSameSizeAs(creditCardRMList);

        verify(mResourcesManager, atLeast(1)).getDrawable(R.drawable.ic_mastercard_brand);

        CreditCardPM creditCardPM = creditCardPMList.get(0);
        assertThat(creditCardPM.getId()).isEqualTo(CreditCardRMGenerator.ID);
        assertThat(creditCardPM.getCvv()).isEqualTo(CreditCardRMGenerator.CVV);
        assertThat(creditCardPM.getExpirationDate()).isEqualTo("01/2020");
        assertThat(creditCardPM.getNumber()).isEqualTo("5252 0621 2637 9381");
        assertThat(creditCardPM.getName()).isEqualTo(CreditCardRMGenerator.NAME.toUpperCase());
        assertThat(creditCardPM.getBrandType()).isNotNull();
    }

    @Test
    public void testIfApplyWouldReturnVisaBrand()  {
        // Given
        List<CreditCardRM> creditCardRMList = CreditCardRMGenerator.generateListBasedOnBrandType(CreditCardRM.BrandType.VISA);

        // When
        mCreditCardConverter.apply(creditCardRMList);

        // Then
        verify(mResourcesManager, atLeast(1)).getDrawable(R.drawable.ic_visa_brand);
    }
}