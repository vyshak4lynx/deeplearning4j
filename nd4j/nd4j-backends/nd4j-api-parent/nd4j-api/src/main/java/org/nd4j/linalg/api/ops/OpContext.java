/*******************************************************************************
 * Copyright (c) 2015-2018 Skymind, Inc.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Apache License, Version 2.0 which is available at
 * https://www.apache.org/licenses/LICENSE-2.0.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 *
 * SPDX-License-Identifier: Apache-2.0
 ******************************************************************************/

package org.nd4j.linalg.api.ops;

import org.bytedeco.javacpp.Pointer;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.primitives.Pair;

import java.util.Collection;
import java.util.List;

/**
 * This interface describes OpContext, abstraction used to setup op for execution.
 *
 * @author raver119@gmail.com
 */
public interface OpContext extends AutoCloseable {

    /**
     * This method sets integer arguments required for operation
     * @param arguments
     */
    void setIArguments(long... arguments);

    List<Long> getIArguments();

    /**
     * This method sets floating point arguments required for operation
     * @param arguments
     */
    void setTArguments(double... arguments);

    List<Double> getTArguments();

    /**
     * This method sets boolean arguments required for operation
     * @param arguments
     */
    void setBArguments(boolean... arguments);

    List<Boolean> getBArguments();

    /**
     * This method sets root-level seed for rng
     * @param seed
     */
    void setRngStates(long rootState, long nodeState);

    /**
     * This method returns RNG states, root first node second
     * @return
     */
    Pair<Long, Long> getRngStates();

    /**
     * This method adds INDArray as input argument for future op call
     *
     * @param index
     * @param array
     */
    void setInputArray(int index, INDArray array);

    /**
     * This method sets provided arrays as input arrays
     * @param arrays
     */
    void setInputArrays(List<INDArray> arrays);

    /**
     * This method sets provided arrays as input arrays
     * @param arrays
     */
    void setInputArrays(INDArray... arrays);

    /**
     * This method returns List of input arrays defined within this context
     * @return
     */
    List<INDArray> getInputArrays();

    /**
     * This method adds INDArray as output for future op call
     * @param index
     * @param array
     */
    void setOutputArray(int index, INDArray array);

    /**
     * This method sets provided arrays as output arrays
     * @param arrays
     */
    void setOutputArrays(List<INDArray> arrays);

    /**
     * This method sets provided arrays as output arrays
     * @param arrays
     */
    void setOutputArrays(INDArray... arrays);

    /**
     * This method returns List of output arrays defined within this context
     * @return
     */
    List<INDArray> getOutputArrays();

    /**
     * This method returns pointer to context, to be used during native op execution
     * @return
     */
    Pointer contextPointer();

    /**
     * This method allows to set op as inplace
     * @param reallyInplace
     */
    void markInplace(boolean reallyInplace);
}
