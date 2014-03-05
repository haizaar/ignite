/* @scala.file.header */

/*
 * ________               ______                    ______   _______
 * __  ___/_____________ ____  /______ _________    __/__ \  __  __ \
 * _____ \ _  ___/_  __ `/__  / _  __ `/__  ___/    ____/ /  _  / / /
 * ____/ / / /__  / /_/ / _  /  / /_/ / _  /        _  __/___/ /_/ /
 * /____/  \___/  \__,_/  /_/   \__,_/  /_/         /____/_(_)____/
 *
 */

package org.gridgain.scalar.lang

import org.gridgain.grid.lang.{GridBiClosure}
import org.gridgain.grid.util.lang.GridLambdaAdapter

/**
 * Wrapping Scala function for `GridClosure2`.
 */
class ScalarClosure2Function[T1, T2, R](val inner: GridBiClosure[T1, T2, R]) extends GridLambdaAdapter
    with ((T1, T2) => R) {
    assert(inner != null)

    peerDeployLike(inner)

    /**
     * Delegates to passed in grid closure.
     */
    def apply(t1: T1, t2: T2): R = {
        inner.apply(t1, t2)
    }
}
