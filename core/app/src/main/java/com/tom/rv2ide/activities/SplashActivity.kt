/*
 *  This file is part of AndroidIDE.
 *
 *  AndroidIDE is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  AndroidIDE is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *   along with AndroidIDE.  If not, see <https://www.gnu.org/licenses/>.
 */
package com.tom.rv2ide.activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.animation.DecelerateInterpolator
import android.view.animation.OvershootInterpolator

/**
 * Branded splash screen for Zeeshan Studio.
 *
 * Shows the Zeeshan Studio logo with a glassmorphism entrance animation
 * before forwarding the user to the onboarding flow.
 *
 * @author Zeeshan
 */
class SplashActivity : Activity() {

  private val handler = Handler(Looper.getMainLooper())

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_splash)

    val logo = findViewById<View>(R.id.splash_logo)
    val title = findViewById<View>(R.id.splash_title)
    val tagline = findViewById<View>(R.id.splash_tagline)
    val loader = findViewById<View>(R.id.splash_loader)

    // Entrance: Z logo pops in with a subtle overshoot (glassmorphism).
    logo.scaleX = 0.5f
    logo.scaleY = 0.5f
    logo.animate()
        .alpha(1f)
        .scaleX(1f)
        .scaleY(1f)
        .setDuration(650)
        .setInterpolator(OvershootInterpolator(1.4f))
        .start()

    // Title fades and slides up.
    title.translationY = 24f
    title.animate()
        .alpha(1f)
        .translationY(0f)
        .setStartDelay(180)
        .setDuration(600)
        .setInterpolator(DecelerateInterpolator())
        .start()

    // Tagline follows the title.
    tagline.translationY = 16f
    tagline.animate()
        .alpha(1f)
        .translationY(0f)
        .setStartDelay(320)
        .setDuration(550)
        .setInterpolator(DecelerateInterpolator())
        .start()

    loader.animate().alpha(1f).setStartDelay(480).setDuration(400).start()

    handler.postDelayed(
        {
          if (isFinishing || isDestroyed) {
            return@postDelayed
          }
          startActivity(Intent(this, OnboardingActivity::class.java))
          overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
          finish()
        },
        1900,
    )
  }

  override fun onDestroy() {
    super.onDestroy()
    handler.removeCallbacksAndMessages(null)
  }
}
