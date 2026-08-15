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
package com.tom.rv2ide.actions.sidebar

import android.content.Context
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.tom.rv2ide.R
import com.tom.rv2ide.actions.ActionData
import com.tom.rv2ide.actions.requireContext
import com.tom.rv2ide.preferences.internal.GeneralPreferences
import kotlin.reflect.KClass

/**
 * A sidebar action which quickly toggles between the Dark Glass and Light
 * Glass themes of Zeeshan Studio by flipping AppCompat night mode.
 *
 * @author Zeeshan
 */
class ThemeToggleSidebarAction(
    context: Context,
    override val order: Int,
) : AbstractSidebarAction() {

  override val id: String = "ide.editor.sidebar.themeToggle"

  override val fragmentClass: KClass<out Fragment>? = null

  init {
    label = context.getString(R.string.action_toggle_theme)
    icon = ContextCompat.getDrawable(context, R.drawable.ic_theme_switch)
    iconRes = R.drawable.ic_theme_switch
  }

  override suspend fun execAction(data: ActionData): Any {
    val ctx = data.requireContext()
    val newMode =
        if (GeneralPreferences.uiMode == AppCompatDelegate.MODE_NIGHT_YES) {
          AppCompatDelegate.MODE_NIGHT_NO
        } else {
          AppCompatDelegate.MODE_NIGHT_YES
        }
    GeneralPreferences.uiMode = newMode
    AppCompatDelegate.setDefaultNightMode(newMode)
    return true
  }
}
