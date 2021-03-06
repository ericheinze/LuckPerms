/*
 * This file is part of LuckPerms, licensed under the MIT License.
 *
 *  Copyright (c) lucko (Luck) <luck@lucko.me>
 *  Copyright (c) contributors
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy
 *  of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the rights
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in all
 *  copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *  SOFTWARE.
 */

package me.lucko.luckperms.api;

/**
 * Represents the result to a "mutation" on an object.
 *
 * @since 4.2
 */
public interface MutateResult {

    /**
     * Instance of {@link MutateResult} which always reports success.
     */
    MutateResult GENERIC_SUCCESS = () -> true;

    /**
     * Instance of {@link MutateResult} which always reports failure.
     */
    MutateResult GENERIC_FAILURE = () -> false;

    /**
     * Gets if the operation which produced this result completed successfully.
     *
     * @return if the result indicates a success
     */
    boolean wasSuccess();

    /**
     * Gets if the operation which produced this result failed.
     *
     * @return if the result indicates a failure
     */
    default boolean wasFailure() {
        return !wasSuccess();
    }

    /**
     * Gets a boolean representation of the result.
     *
     * <p>A value of <code>true</code> marks that the operation {@link #wasSuccess() was a success}
     * and a value of <code>false</code> marks that the operation
     * {@link #wasFailure() was a failure}.</p>
     *
     * @return a boolean representation
     */
    default boolean asBoolean() {
        return wasSuccess();
    }

}
