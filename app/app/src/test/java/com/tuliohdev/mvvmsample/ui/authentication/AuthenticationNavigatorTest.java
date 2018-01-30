package com.tuliohdev.mvvmsample.ui.authentication;

import com.tuliohdev.mvvmsample.R;
import com.tuliohdev.mvvmsample.ui.authentication.fragment.AuthenticationStep1Fragment;
import com.tuliohdev.mvvmsample.ui.authentication.fragment.AuthenticationStep2Fragment;
import com.tuliohdev.mvvmsample.ui.authentication.fragment.AuthenticationStep3Fragment;
import com.tuliohdev.mvvmsample.utils.FragmentHelper;
import com.tuliohdev.mvvmsample.utils.ResourcesManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

/**
 * Created by tulio on 29/01/2018.
 */
@RunWith(MockitoJUnitRunner.class)
public class AuthenticationNavigatorTest {

    @Mock
    private FragmentHelper mFragmentHelper;
    @Mock
    private ResourcesManager mResourcesManager;
    @Mock
    private AuthenticationNavigator.ViewConfigger mViewConfigger;

    @Test
    public void testIfInitializeShouldCallFirstStep() {
        // Given
        AuthenticationNavigator authenticationNavigator = new AuthenticationNavigator(
            mFragmentHelper, mResourcesManager, mViewConfigger);

        // When
        authenticationNavigator.initialize();

        // Then
        verify(mViewConfigger, atLeastOnce()).setTitle(anyString());
        verify(mResourcesManager, atLeastOnce()).getString(R.string.basic_data);
        verify(mFragmentHelper, atLeastOnce()).replaceFragment(isA(AuthenticationStep1Fragment.class));
        verify(mViewConfigger, never()).hideNextButton();
    }

    @Test
    public void testIfOnUserBasicDataFilledIsCalledWithTrueThenSecondStepWouldBeCalled() {
        // Given
        AuthenticationNavigator authenticationNavigator = new AuthenticationNavigator(
            mFragmentHelper, mResourcesManager, mViewConfigger);

        // When
        authenticationNavigator.initialize();
        authenticationNavigator.onUserBasicDataFilled(true);

        // Then
        verify(mViewConfigger, atLeastOnce()).setTitle(anyString());
        verify(mResourcesManager, atLeastOnce()).getString(R.string.address_data);
        verify(mFragmentHelper, atLeastOnce()).replaceFragment(any(AuthenticationStep2Fragment.class));
        verify(mViewConfigger, never()).hideNextButton();
    }

    @Test
    public void testIfOnUserBasicDataFilledIsCalledWithFalseThenThirdStepWouldBeCalled() {
        // Given
        AuthenticationNavigator authenticationNavigator = new AuthenticationNavigator(
            mFragmentHelper, mResourcesManager, mViewConfigger);

        // When
        authenticationNavigator.initialize();
        authenticationNavigator.onUserBasicDataFilled(false);

        // Then
        verify(mViewConfigger, atLeastOnce()).setTitle(anyString());
        verify(mResourcesManager, atLeastOnce()).getString(R.string.successful_registered);
        verify(mFragmentHelper, atLeastOnce()).replaceFragment(any(AuthenticationStep3Fragment.class));
        verify(mViewConfigger, atLeastOnce()).hideNextButton();
    }

    @Test
    public void testIfOAddressFilledIsCalledThenThirdStepWouldBeCalled() {
        // Given
        AuthenticationNavigator authenticationNavigator = new AuthenticationNavigator(
            mFragmentHelper, mResourcesManager, mViewConfigger);

        // When
        authenticationNavigator.initialize();
        authenticationNavigator.onUserBasicDataFilled(true); // this parameter does not matter in this test
        authenticationNavigator.onAddressFilled();

        // Then
        verify(mViewConfigger, atLeastOnce()).setTitle(anyString());
        verify(mResourcesManager, atLeastOnce()).getString(R.string.successful_registered);
        verify(mFragmentHelper, atLeastOnce()).replaceFragment(any(AuthenticationStep3Fragment.class));
        verify(mViewConfigger, atLeastOnce()).hideNextButton();
    }
}