package com.tuliohdev.mvvmsample.ui.main.viewmodel;

import com.tuliohdev.mvvmsample.TrampolineSchedulerRule;
import com.tuliohdev.mvvmsample.data.model.presentationmodel.CreditCardPM;
import com.tuliohdev.mvvmsample.data.model.repositorymodel.CreditCardRM;
import com.tuliohdev.mvvmsample.data.source.repository.creditcard.CreditCardRepository;
import com.tuliohdev.mvvmsample.testutils.CreditCardRMGenerator;
import com.tuliohdev.mvvmsample.ui.main.viewmodel.MainViewModel;
import com.tuliohdev.mvvmsample.utils.ResourcesManager;
import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.observers.TestObserver;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by tulio on 28/01/18.
 */
@RunWith(MockitoJUnitRunner.class)
public class MainViewModelTest {

    @Mock
    private CreditCardRepository mCreditCardRepository;
    @Mock
    private ResourcesManager mResourcesManager;

    private MainViewModel mMainViewModel;

    @Before
    public void setUp() throws Exception {
        List<CreditCardRM> mockedCreditCards = CreditCardRMGenerator.generateList();

        when(mCreditCardRepository.clearCache()).thenReturn(Completable.complete());
        when(mCreditCardRepository.getAllCreditCards()).thenReturn(Single.just(mockedCreditCards));
    }

    @Test
    public void testIfGetCreditCardPMWillClearCacheBeforeReturnList() {
        // Given
        mMainViewModel = new MainViewModel(mCreditCardRepository, mResourcesManager);

        // When
        mMainViewModel.getCreditCardPM();

        // Then
        verify(mCreditCardRepository, times(1)).clearCache();
        verify(mCreditCardRepository, times(1)).getAllCreditCards();
    }

    @Test
    public void testIfGetCreditCardPMWillNotClearCacheBeforeReturnList() {
        // Given
        mMainViewModel = new MainViewModel(mCreditCardRepository, mResourcesManager);

        // When
        mMainViewModel.getCreditCardPM(); // calling "getCreditCardPM()" first time to get fresh data
        mMainViewModel.getCreditCardPM(); // calling "getCreditCardPM()" second time to get credit card list from cache

        // Then
        verify(mCreditCardRepository, times(1)).clearCache();
        verify(mCreditCardRepository, times(2)).getAllCreditCards();
    }
}