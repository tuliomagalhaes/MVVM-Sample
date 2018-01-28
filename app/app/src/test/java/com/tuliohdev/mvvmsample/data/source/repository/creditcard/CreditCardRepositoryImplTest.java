package com.tuliohdev.mvvmsample.data.source.repository.creditcard;

import com.tuliohdev.mvvmsample.TrampolineSchedulerRule;
import com.tuliohdev.mvvmsample.data.source.local.CreditCardDao;
import com.tuliohdev.mvvmsample.data.model.repositorymodel.CreditCardRM;
import com.tuliohdev.mvvmsample.data.source.remote.CreditCardApiService;
import com.tuliohdev.mvvmsample.testutils.CreditCardRMGenerator;
import io.reactivex.Single;
import io.reactivex.observers.TestObserver;
import java.util.Collections;
import java.util.List;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

/**
 * Created by tulio on 25/01/18.
 */
@RunWith(MockitoJUnitRunner.class)
public class CreditCardRepositoryImplTest {

    @Rule
    public final TrampolineSchedulerRule trampolineSchedulerRule = new TrampolineSchedulerRule();

    @Mock
    private CreditCardApiService mCreditCardApiService;
    @Mock
    private CreditCardDao mCreditCardDao;

    private CreditCardRepositoryImpl creditCardRepository;

    @Before
    public void setUp() {
        creditCardRepository = new CreditCardRepositoryImpl(mCreditCardApiService, mCreditCardDao);
    }

    @Test
    public void testWhenLocalDatabaseIsEmptyAndFetchFromRemote() {
        // Given
        List<CreditCardRM> mockedCreditCards = CreditCardRMGenerator.generateList();

        // When
        when(mCreditCardApiService.getAllCreditCards()).thenReturn(Single.just(mockedCreditCards));
        when(mCreditCardDao.getAllCreditCards()).thenReturn(Single.just(Collections.emptyList()));
        TestObserver<List<CreditCardRM>> testObservable = creditCardRepository.getAllCreditCards().test();

        // Then
        verify(mCreditCardDao).insertCreditCardList(anyListOf(CreditCardRM.class));
        testObservable
            .assertComplete()
            .assertNoErrors()
            .assertValue(creditCards -> creditCards.size() == mockedCreditCards.size());
    }

    @Test
    public void testWhenLocalDatabaseHasCachedData() {
        // Given
        List<CreditCardRM> mockedCreditCards = CreditCardRMGenerator.generateList();

        // When
        when(mCreditCardApiService.getAllCreditCards()).thenReturn(Single.just(mockedCreditCards));
        when(mCreditCardDao.getAllCreditCards()).thenReturn(Single.just(mockedCreditCards));
        TestObserver<List<CreditCardRM>> testObservable = creditCardRepository.getAllCreditCards().test();

        // Then
        verify(mCreditCardDao, never()).insertCreditCardList(anyListOf(CreditCardRM.class));
        testObservable
            .assertComplete()
            .assertNoErrors()
            .assertValue(creditCards -> creditCards.size() == mockedCreditCards.size());
    }
}